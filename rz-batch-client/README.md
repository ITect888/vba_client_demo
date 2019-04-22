# 使用示例

java -jar rz-batch-client-yyyymmdd.jar

注：需要jdk8及以上

# 配置和输入

##    rz-batch-client-YYYYMMDD.jar

小程序jar包

##    application.yml

应用配置文件，具体可见文件备注。YML格式，使用nodepad++等编辑。

### 配置VBA数据库（spring.datasource.dynamic.datasource.mysql）

注：如生产网络上不通，但小程序要求必须能够连接到一个数据库，则配置测试数据库即可，注意这时断言中关于数据库流水部分的将无效。

### 应用配置my-app

可指定

- VBA访问地址（url）

- 输入文件或者文件夹（input）

- 输出文件的文件名前缀（output-file-name-prefix）

- 并发量（n-threads）

- 模式（mode），模式共包括：**机构跑批**和**自动验证小程序**，见后说明

- **指定发送笔数**（spec-num2-post，大于0有效，小于等于0则只发送excel已有数据的量）。

  注：**输出文件名规则**为：输出文件的文件名前缀（application.yml的output-file-name-prefix配置）+“-”+**截止到本输出文件已读入输入数据的笔数**+输入文件名。因为某个输入文件会被多次使用，以满足“发送最少笔数限制”spec-num2-post,故写出的文件需要按照顺序区分命名。

### 机构跑批模式下的参数title-trans

包括：

1. VBA账户参数（机构账号ptyacct，机构编号ptycd，会话秘钥pty-key）和接口号（funcno）。

2. **one-plus-n**是否调用N次102结果查询

3. chi2field-list中文title换为字段名的映射。
   **字段名规则**为：

   - toSign\_开头：字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数。

   - toAes_toUrl_toBase64\_开头：字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数。

   - toPicBase64\__开头：字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数。

   - toUrl_toBase64\_开头：字段名为title去掉toUrl_toBase64_开头后的值，字段值不参加签名，并以url编码再base64编码形式post发送请求的参数。

   - 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数。

     以手机实名认证为例
    ```yml
     title-trans:
      chi2field-list:
        - chi: 手机号
          field: toSign_phoneno
        - chi: 身份证号
          field: toAes_toUrl_toBase64_certseq
        - chi: 姓名
          field: usernm
    ```

4. field-omit-list接口必填字段输入参数中， 机构跑批入参_模板没有，取指定值的字段。
     以银行卡认证为例
     ```yml
      field-omit-list:
        - chi: ""
          field: toSign_code
        - chi: ""
          field: toSign_sysseqnb
        - chi: "0"
          field: toSign_sourcechnl
        - chi: "0"
          field: toSign_biztypdesc
        - chi: "0"
          field: toSign_biztyp
        - chi: "0"
          field: toSign_placeid
     ```


### 机构跑批模式下的参数resp-extract

机构跑批响应结果的提取配置resp-extract,包括：

1. field2chi-list从响应结果中提取的字段及其对应输出中文title
   以手机实名认证为例

   ```yml
   resp-extract:
     field2chi-list:
      - chi: 返回码
        field: respcd
      - chi: 返回信息
        field: respinfo
      - chi: 归属地
        field: phoneProvCity
      - chi: 运营商
        field: phoneOperator
      - chi: 结果
        field: resultdata 
      - chi: 交易状态
        field: status     
   ```
2. field2value2chi-list提取的字段中，字段值需要数据字典中文映射的 
   以手机实名认证为例
   ```yml
resp-extract:     
    field2value2chi-list:
      - field: resultdata	
        value2chi-list: 
         - value: "0"
           chi: 一致
         - value: "1"
           chi: 不一致   
      - field: status	
        value2chi-list: 
         - value: "03"
           chi: 失败结束
         - value: "00"
           chi: 成功结束  
   ```

##    log4j2-spring.xml

 log4j2日志配置文件

##    自动验证小程序入参_模板
文件夹下可包括多个**自动验证小程序**模式下的输入excel（*2007以上版本*）

###  文件模板

*具体见excel示例*

#### 第一行为入参分类title

*入参分类的每个分类可以是合并多列的单元格；连续多列属于同一合并单元格，这些列数据就属于这个单元格文字描述的类型*

包括

| 案例说明                             | 会话秘钥 | 业务请求入参                                                 | 期望值入参                                                   |
| ------------------------------------ | -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 其下的所有列只供人查阅，程序并不使用 | 必须有   | 其下的所有列，根据不同服务，入参数目不一，都遵循**字段名规则**（见前述）</br> | 其下的所有列表示期望得到的返回结果，用于获得断言输出。</br>其列下的值都是正则表达式，因此特殊字符如括号需要转义，如认证一致\(通过\)转义为认证一致\\(通过\\)。</br>期望值入参的title和断言输出的title一一对应，除了开头，前者是expected_（或db_expected_）后者是assert_（或db_assert_），其他都一模一样。 |

**期望值入参title规则**

- expected\_开头：返回报文中为title去掉expected_的字段。
- db_expected\_开头：数据库表中title去掉db_expected_的字段。

#### 第二行为输入数据字段名title

*大小写敏感，无合并单元格*。遵循**字段名规则**和**期望值入参title规则**，对应VBA接口文档的输入字段名

如包括

| 案例说明 | 会话秘钥               | 业务请求入参 | 期望值入参         |         |                |              |                      |        |                              |               |                   |                |                  |                   |                   |                 |                 |                   |                    |                    |                      |
| -------- | ---------------------- | ------------ | ------------------ | ------- | -------------- | ------------ | -------------------- | ------ | ---------------------------- | ------------- | ----------------- | -------------- | ---------------- | ----------------- | ----------------- | --------------- | --------------- | ----------------- | ------------------ | ------------------ | -------------------- |
| caseNo   | 是否调用N次102结果查询 | case_desc    | ptyKey             | funcNo  | toSign_ptyacct | toSign_ptycd | toPicBase64_videopic | usernm | toAes_toUrl_toBase64_certseq | toSign_biztyp | toSign_biztypdesc | toSign_placeid | toSign_timestamp | toSign_sourcechnl | expected_error_no | expected_status | expected_respcd | expected_respinfo | db_expected_mPSSim | db_expected_respCd | db_expected_respInfo |
| 1        | true                   | 测试正例     | vba2ciasacctPtykey | 2000101 | ciasacct       | 0000100000   | F:\30K高清案例.jpg   | 范燕军 | 341227198912173710           | spec_         | spec_             | spec_          | spec_time        | spec_             | 0                 | 00              | 1000            | 认证一致\\(通过\\) | .*                 | .*     | .*                   |



需要对应VBA接口文档的输入字段名

#### 第三及之后为数据行

**业务请求入参值规则**：

 * spec_则是默认固定值:默认为0

 * spec_time是程序自动取当前时间

 * 否则，填写什么值就使用什么值

    

注：输入文件必须是office excel编辑的，不支持WPS编辑保存的，后者会出现读入多个空白行的问题。

注：直接忽略空行，而不至于引起异常。同时，行处理时捕获异常。忽略本行，小程序继续。



## 自动验证小程序输出

*具体见excel示例*

包括如下分类:

- 期望值入参断言结果
- sysseqnb（交易流水）	
- results（响应报文）包括请求响应时间和耗时
- 数据库字段结果的json格式，包括库内记录的交易开始、结束时间和耗时
- 输入

举例如

| assert_error_no | assert_status | assert_respcd | assert_respinfo                         | db_assert_mPSSim | db_assert_respCd        | db_assert_respInfo                         | sysseqnb                   | results                                                      | 交易耗时（毫秒） | 交易响应时间            | 交易发起时间            | 数据库字段结果的json格式                                     | 数据库流水时差（毫秒） | 数据库结束时间          | 数据库开始时间          | caseNo | 是否调用N次102结果查询 | case_desc | ptyKey             | funcNo  | toSign_ptyacct | toSign_ptycd | toSign_phoneno | usernm | toAes_toUrl_toBase64_certseq | toSign_biztyp | toSign_biztypdesc | toSign_placeid | toSign_timestamp    | toSign_sourcechnl | expected_error_no | expected_status | expected_respcd | expected_respinfo | db_expected_mPSSim | db_expected_respCd | db_expected_respInfo |
| --------------- | ------------- | ------------- | --------------------------------------- | ---------------- | ----------------------- | ------------------------------------------ | -------------------------- | ------------------------------------------------------------ | ---------------- | ----------------------- | ----------------------- | ------------------------------------------------------------ | ---------------------- | ----------------------- | ----------------------- | ------ | ---------------------- | --------- | ------------------ | ------- | -------------- | ------------ | -------------- | ------ | ---------------------------- | ------------- | ----------------- | -------------- | ------------------- | ----------------- | ----------------- | --------------- | --------------- | ----------------- | ------------------ | ------------------ | -------------------- |
| false\|-1000\|0 | true          | true          | false\|认证一致（通过）\|认证一致(通过) | false\|75.0\|0.0 | false\|5400001\|1099001 | false\|系统异常码:.*\|本地单手机库命中结果 | 19103520190330611928170001 | {"error_no":"0","results":[{"respinfo":"认证一致(通过)","phoneProvCity":"上海","status":"00","phoneOperator":"移动","biztyp":"0","respcd":"10000","certseq":"341227198912173710","resultdata":"0","sysseqnb":"19103520190330611928170001","name":"范燕军","ptyacct":"ciasacct","ptycd":"0000100000","phoneno":"15121016001"}],"dsName":["results"],"error_info":""} | 397              | 2019-03-30T19:28:17.662 | 2019-03-30T19:28:17.265 | {"accountCard":"","accountCode":"","accountName":"","addr":"","authFileType":"","authTyp":"10","bizAddr":"0","bizTyp":"0","bizTypDesc":"0","bmtopolice":"证通股份优先公司","certFront":"","certNegative":"","certSeq":"341227198912173710","cretm":"2019-03-30T19:28:16.986","facePic":"","facePicMPS":"","fsdtopolice":"上海","isCount":"1","isOverDraft":"0","localSim":0.0,"mPSSim":0.0,"price":0.000000,"ptyAcct":"ciasacct","ptyCd":"0000100000","ptyRespcd":"10000","ptyRespinfo":"认证一致(通过)","res1":"0","res10":"","res2":"移动","res3":"上海","res9":"","respCd":"1099001","respInfo":"本地单手机库命中结果","sex":"","sourcechnl":"0","status":"00","subAuthTyp":"10_1","sysSeqNb":"19103520190330611928170001","telephone":"15121016001","updatetm":"2019-03-30T19:28:17.004","userNm":"范燕军","vedio":"","ywlxtopolice":"40"} | 18                     | 2019-03-30T19:28:17.004 | 2019-03-30T19:28:16.986 | 2      | false                  | 测试反例  | vba2ciasacctPtykey | 2000239 | ciasacct       | 0000100000   | 15121016001    | 范燕军 | 341227198912173710           | 0             | 0                 | 0              | 2019-03-30 19:28:17 | 0                 | -1000             | 00              | .*              | 认证一致（通过）  | 75.0               | 5400001            | 系统异常码:.*        |

遵循**输出文件名规则**



##  机构跑批入参_模板

文件夹下可包括多个**机构跑批**模式下的输入excel（*2007以上版本*）

### 文件模板

*具体见excel示例*

以手机实名认证为例，当application.yml中**机构跑批模式下的参数title-trans的chi2field-list和field-omit-list正确配置后**，入参表格如下

| 身份证号           | 姓名            | 手机号      |
| ------------------ | --------------- | ----------- |
| 211403198601149618 | caseTypeCode_11 | 15142982121 |

- 第一行为中文title，非合并单元格

- 第二行及之后为数据，非合并单元格


注：输入文件必须是office excel编辑的，不支持WPS编辑保存的，后者会出现读入多个空白行的问题。

注：直接忽略空行，而不至于引起异常。同时，行处理时捕获异常。忽略本行，小程序继续。



## 机构跑批输出

*具体见excel示例*

包括如下分类:

- 指定提取的字段（application.yml的resp-extract配置，这些列的值可配置数据字典）

- sysseqnb（交易流水）	

- results（响应报文）

- 输入

以手机实名认证为例

| 归属地     | 结果 | 运营商 | 返回信息       | 返回码 | 交易状态 | sysseqnb                   | results                                                      | 手机号      | 身份证号           | 姓名    |
| ---------- | ---- | ------ | -------------- | ------ | -------- | -------------------------- | ------------------------------------------------------------ | ----------- | ------------------ | ------- |
| 辽宁葫芦岛 | 一致 | 移动   | 认证一致(通过) | 10000  | 成功结束 | 19103520190330611919300001 | {"error_no":"0","results":[{"respinfo":"认证一致(通过)","phoneProvCity":"辽宁葫芦岛","status":"00","phoneOperator":"移动","biztyp":"0","respcd":"10000","certseq":"211403198601149618","resultdata":"0","sysseqnb":"19103520190330611919300001","name":"范燕军1","ptyacct":"ciasacct","ptycd":"0000100000","phoneno":"15142982121"}],"dsName":["results"],"error_info":""} | 15142982121 | 211403198601149618 | 范燕军1 |

遵循**输出文件名规则**

