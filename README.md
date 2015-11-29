Couch Stats plugin for Jenkins
===============================

[![Build Status](https://travis-ci.org/garethjevans/couch-stats-plugin.svg?branch=master)](https://travis-ci.org/garethjevans/couch-stats-plugin)

  A plugin to push build statistics to a couchdb/cloudant instance.

Configuration Options
=====================

Nativate to `Manage Jenkins` > `Configure System`

Under the heading `CouchDB Statistics Configuration` complete the following entries:

  * Url (required)
  * Username (required)
  * Password (required)
  * Document (required) - the name of the document to store information

Information Captured:

  * Job Name
  * Status
  * Duration

TODO
====

 * Need to implement form validation for the config pages
 * Capture extra information, timestamp, triggered by, build node... 
 * Move plugin hosting to jenkins-ci.org
 * Create 'proper' release for plugin

