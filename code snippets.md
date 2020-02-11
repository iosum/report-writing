## Displaying the Available Print Services

```java
PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);  
for (int i = 0; i < services.length; i++) {  
	System.out.println(services[i].getName());  
}
```

## Checking the Default Printer for GIF Support via URL

```java
PrintService service = PrintServiceLookup.lookupDefaultPrintService();
DocFlavor flavor = DocFlavor.URL.GIF;
	if (!service.isDocFlavorSupported(flavor)) {
		System.err.println("The printer does not support the appropriate DocFlavor");
	}
```