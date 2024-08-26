I list photos with their thumnailLinks from Google Drive API and resize them. 

This project is implemented for the sake of practising OAuth between Spring Boot application and Google Drive API.
Also, I tried to practice some multi-module maven project using hexagonal architecture and DDD principles although this use-case is not a domain-heavy one.

modules : 
- application (controller)
- domain
    - application-service (talks to ports and resizes photo)
    - domain-core (just a simple Photo entity)
- dataaccess (not implemented) 
- google-drive-integration (responsible for fetching photos from Google Drive and authorizaton stuff)


* In project, there are some hard-coded and non-properly implemented code. 
* Thymeleaf templates developed with the help of AI, I have no knowledge enough about html,css, js codes and Spring MVC concept. 

* When user wants to list his/her photos in Drive, domain layer communicates to a port, ThirdPartyPhotoProvider.
    * GoogleDrivePhotoDriver is a kind of adapter implementing that port.
    * If program is not authorizated to access photos, in google-drive module,  an exception is thrown and application layer handles it, redirect user authorization link.
    * To make application layer  independent of the logic and the flow of Google Drive communication, I implemented OAuthController in google module to handle callback of Google.
    * My domain layer and application layer are only aware of the exception named ThirdPartyAuthorizationException.
    * In Google module, there is a subtype named GoogleDriveAuthorizationException.
 
