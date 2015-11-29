Couch Stats plugin for Jenkins
===============================

[![Build Status](https://travis-ci.org/garethjevans/couch-stats-plugin.svg?branch=master)](https://travis-ci.org/garethjevans/couch-stats-plugin)

  A plugin to push build statistics to a couchdb/cloudant instance.

Configuration Options
=====================

Url (required)

Username (required)

Password (required)

Document (required)

Information Captured:

  * Job Name
  * Status
  * Duration

TODO
====

 * Need to implement form validation for the config pages
 * Capture extra information, timestamp, triggered by, build node... 
