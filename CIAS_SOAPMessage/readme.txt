环境：
Eclipse+JDK 1.6 

文本编码：
UTF-8

localhost.localdomain.crt:
测试环境的服务器证书，生产时需要更换。

serverCrt.keystore：
使用keytool -import -alias serverkey -file localhost.localdomain.crt -keystore serverCrt.keystore从服务器证书localhost.localdomain.crt中生成的keystore。

src：
MESSAGE方式进行SOAP消息的创建、传递和处理的示例源代码。