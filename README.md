
# XML Node Counter

The application contains one servlet that accepts parameters String **nodeName** and int **cnt**.


The servlet reads an xml file from the disk by location from my.properties file,
and finds the first cnt nodes that have node name equal to nodeName and write their text content as a response

# Example

**Params**

 - nodeName=hello

  - cnt=2

**XML-file**
```
<ahoj>
   <hello>something</hello>
   <guten-tag>
         <morn>
             <hello>192</hello>
         </morn>
         <morn>
             <hello>192</hello>
         </morn>
         <hello>nothing</hello>
   </guten-tag>
</ahoj>
```

 **The response**

 something

192


----------

For testing application clone repo and make in the root directory.

 ``` mvn tomcat7:run ```
 
After that service will be available http://localhost:8080