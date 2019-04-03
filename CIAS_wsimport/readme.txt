环境：
Eclipse+JDK 1.7

文本编码：
UTF-8

localhost.localdomain.crt:
测试环境的服务器证书，生产时需要更换。

serverCrt.keystore：
使用keytool -import -alias serverkey -file localhost.localdomain.crt -keystore serverCrt.keystore从服务器证书localhost.localdomain.crt中生成的keystore。

ICService.xml：
测试环境的WSDL文件

src：
使用从WSDL文件ICService.xml中生成com.zhengtong.service.ws的Stub代码的示例源代码。