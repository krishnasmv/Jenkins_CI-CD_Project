# TOMCAT SETUP:
wget http://dlcdn.apache.org/tomcat/tomcat-9/v9.0.80/bin/apache-tomcat-9.0.80.tar.gz
tar -zxvf apache-tomcat-9.0.80.tar.gz
vim apache-tomcat-9.0.80/conf/tomcat-users.xml

  <role rolename="manager-gui"/>
  <role rolename="manager-script"/>
  <user username="tomcat" password="raham123" roles="manager-gui, manager-script"/>

vim apache-tomcat-9.0.80/webapps/manager/META-INF/context.xml (delete 21,22)
sh apache-tomcat-9.0.80/bin/startup.sh

# public-ip slave:8080
# manager app -- > usrername and passowd

# Download pluguin -- > Deploy to container : this is to deploy on tomcat