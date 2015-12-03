CouchDB Statistics plugin for Jenkins
===============================

[![Build Status](https://travis-ci.org/garethjevans/couchdb-statistics-plugin.svg?branch=master)](https://travis-ci.org/garethjevans/couchdb-statistics-plugin)

  A plugin to push build statistics to a couchdb/cloudant instance.

  https://wiki.jenkins-ci.org/display/JENKINS/CouchDB+Statistics+Plugin

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
 * Capture extra information e.g. triggered by, build node... 
