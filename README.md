croz
====

### 1. DIO

#### 01 utils 
project for utility classes:
	
* IOUtils
	* reads / writes files using Java 7 IO support
	* TODO: change using line processor for large files
* bundle
	* custom bundle for getting instances of Validator implementations instead of key values
* Validators
	* regex based validators
	* TODO: use spring validation?
* ParseUtils
	* done using java split
	* commons lang could be used instead: http://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html
		
#### 02 file validator
read file, parse and validate lines, and then write the results in new file


### 2. DIO 

#### 03 model
containing model classes for easying the DAO and WEB manipulation

#### 04 daoModule
dao and service spring components

* data source: embedded db
	* mysql definition and sql scripts provided for production mode
* FileRepository
	* responsible for data manipulation
	* TODO: use RowCallbackHandler to handle bigger data sets
* CrozFileValidation
	* service for validating data provided from repository

#### 05 web

### 3. DIO

