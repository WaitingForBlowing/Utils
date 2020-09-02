# Utils

## Introduction
  Personal Utils Libruary
## Details
- EmailUtil.java  
  This utils is used to send emails by java codes.  
  The usage has been written in the code comments.  
  `maven dependency`
  ``````
  <dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>VERSION</version>
  </dependency>
  <dependency>
    <groupId>javax.mail</groupId>
    <artifactId>javax.mail-api</artifactId>
    <version>VERSION</version>
  </dependency>
  ````````
- MyBatisUtil.java  
  If you want to use framword MyBatis , you may write many repetitive code like get and close session , then you can use this util to simplify the work
  The usage has been written in the code comments.  
  `maven dependency`
  ``````
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>VERSION</version>
  </dependency>
  ````````
- TimeUtil.java  
 If we want to get the time now in the java code ,maybe we should use class _Date_ ,but the string of Object _Date_ is not the form we want.And we also have some needs like format some date string to another format.These java codes are a little complex and repetitive,so this util may give you some help.  
 The usage has been written in the code comments. 
