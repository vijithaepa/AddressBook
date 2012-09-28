This contains the set of instructions required to build and run the address book application.

Contents :
==========
   .
   |──src
   |  |─main
   |	|─java
   |	  |─com
   |	    |─genix
   |	      |─addressbook
   |		|─dao
   |		|─entity
   |		|─exception
   |		|─manager
   |		  |─impl
   |		|─presentation
   |		|─util
   |		|─validation
   |	|─resources
   |	  |─META-INF
   |	  |─spring
   |  |─test
   |	|─java
   |	  |─com
   |	    |─genix
   |	      |─addressbook
   |		|─entity
   |		|─manager
   |		  |─impl
   |		|─util
   |		|─validation
   |	|─resources
   |──target
   |  |─classes
   |  |─test-classes
   |──h2db.h2.db
   |──pom.xml



Building the Project.
====================

Pre-requisites
--------------
JDK 1.5.x or higher
Maven 2 or higher
set java_home and m2_home.
eClipse 3.5 or higher

Steps:
------
1 - Unzip the AddressBook.zip
2 - import project to eClipse IDE (Existing Projects in Workspace > Browse and locate the extracted "AddressBook" folder)
3 - Configure Project Build path and add a new Variable "M2_REPO" point to the directory "<<Local-User-Directory>>/.M2/repository"
4 - Go to the project home directory AddressBook, and run 
    - mvn clean package
    - This might take a few seconds to download all the dependencies to your local M2 repo.
5 - To run the tests,
   - mvn clean test

Running the application.
========================

In eClipse IDE : Right Click on the File "AddressForm.java"(/AddressBook/src/main/java/com/genix/addressbook/presentation)
		 Run As -> Java Application

- Follow the prompts made by the application.



