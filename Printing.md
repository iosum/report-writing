## Java printing 4 steps

1. Locate print services (printers), optionally limiting the list of those returned to the ones that support the capabilities your application needs. 
- Print services are  represented as instances of `PrintService` implementations.  

2. Create a print job by calling the `createPrintJob()` method defined in the `PrintService` interface. The print job is represented by an instance of  `DocPrintJob`.  

- `DocPrintJob.createPrintJob(PrintService interface)`

3. Create an implementation of the Doc interface that describes the data you want to print. You also have the option of creating an instance of  `PrintRequestAttributeSet` that describes the printing options you want.  

- the data you want to print
-  the printing options you want

4. Initiate printing by calling the `print()` method defined in the `DocPrintJob` interface, specifying the Doc you created in the previous step and the  `PrintRequestAttributeSet` or a null value.


---

## Locating Print Services

You locate a printer using one of three **static** methods defined in the `PrintServiceLookup` class. The simplest  
of the three methods is `lookupDefaultPrintService()`, and as its name implies, it returns a reference to the  
service that represents your default printer.

- 找出 default printer
```java
PrintService service =  PrintServiceLookup.lookupDefaultPrintService();
```


- In practice, you’ll typically want  
to select only those printers that are able to handle the type of data you want to print and that support  
the features your application needs, such as color or two-sided printing

- 選顏色, 雙面該要怎麼辦?
	- 有 2 個 static method, 一個是` lookupPrintServices()`, 另外一個是 `lookupMultiDocPrintServices()`

- `lookupPrintServices(parameter1,parameter2)`
	- `parameter1` : an instance of `DocFlavor` 
	- `parameter2` : an instance of some implementation of the `AttributeSet` interface
	- can specify `null` to both `parameter1` and `parameter2`
	- return `PrintService`, in which printers that is available
	- get the name of the printer : use `getName()`


---
Code snippet:
Displaying the Available Print Services
