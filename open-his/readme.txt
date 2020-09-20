1.项目的前期准备：
    linux上安装jdk,可以通过在线安装的方式(联网)：
    命令：
        查找jdk:  yum search openjdk
        安装： yum -y install 安装的版本
        验证：java -version
     也可以使用安装包安装，配置环境变量就行。
2.安装redis
3.安装fastdfs
4.zookeeper
5.dubbo-admin(远程服务管理)
    可以通过这个地址下载：
        https://github.com/apache/dubbo-admin/tree/master
    下载完之后解压，进入到dubbo-admin,cmd运行mvn package命令打包
    将jar上传到我们的虚拟机运行，运行命令为：
        后台启动： nohup java -jar dubbo-admin-0.0.1-SNAPSHOT.jar  >/dev/null &

6.mysql和idea就不过多介绍了，懂得都懂