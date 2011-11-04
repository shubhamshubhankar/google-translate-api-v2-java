Google Translate API v2 Java
----------------------------

An unofficial Java wrapper for Google Translate API v2 (http://code.google.com/apis/language/translate/v2/getting_started.html).
For feature requests / bug reports / updates, please visit us at http://code.google.com/p/google-translate-api-v2-java.

Files
------------------
* google-translate-api-v2-core-XXX.jar - Contains full comprehensive access to all the API functionality.
  Depends on all the JAR files contained in lib-core

* google-translate-api-v2-cli-XXX.jar - Contains full comprehensive access to all the API functionality using a Command Line Interface.
  Depends on google-translate-api-v2-core-XXX.jar and all the JAR files contained in lib-core and lib-cli.



What's new?

Version 0.5
------------
* translate	- Translates source text(s) from source language to target language.
* languages	- List the source and target languages supported by the translate methods.
* detect    - Detect language of source text(s).