Gelfj - Changelog
=================

Release 1.1.14
--------------
   
   7. Fix for issue #90 - https://github.com/t0xa/gelfj/issues/90
   6. Fix for issue #95 - https://github.com/t0xa/gelfj/issues/95
   5. Merge pull request #96 from samilaine/zerolenmsgs - https://github.com/t0xa/gelfj/pull/96
   4. Merge pull request #93 from martin-walsh/issue-92 - Ensure MDC access is safe across all Appender threads (https://github.com/t0xa/gelfj/pull/93)
   3. Merge pull request #91 from thorgull/master - Fix NPE when throwableInformation.getThrowable() return null.
   2. Merge pull request #89 from grzegorz-zur/master  - Fixed udp buffer error   
   1. Merge pull request #88 from arteam/default_tcp - Correct info about transport protocol in graylogHost

Release 1.1.11
--------------

2015-04-24
   
   ENH: More logging around TCP, UDP and AMQP senders to give more debug information. Issue #87

Release 1.1.10
--------------

2015-03-26

   ENH: (@mmuruganandam) Enabled the support for OSGI bundling.  Updated the Maven POM to be compatible with 1.6 and above for @Override issues with 1.5.

Release 1.1.9
-------------

For wider platform support Java 1.5 support added. Thanks @dougporter!

Release 1.1.7
-------------

2014-07-15

   DEF: (@danieljamesscott) Issue #78 - Changed dependency to log4j 1.2.17
   ENH: (@dabloem) Issue #77 - add additional setter for additionalField(s)


Release 1.1.5
-------------

2014-06-08

   ENH: Several enhancements for AMQP and RabbitMQ


Release 1.1.4
-------------

2013-12-25
   
   Frohe Weihnachten! 

   DEF: (@h0nIg) ensure that all resources are closed for AMQP transport (https://github.com/t0xa/gelfj/pull/67)

Release 1.1.1
-------------

2013-08-29

   DEF: (@GBT) Issue #62: FIX when graylogHost starts with tcp: or udp:

   ENH: (@h0nIg) Issue #52: Added log4j layout support


Release 1.1
-----------

2013-08-29

   ENH: (@twinforces) Issue #18: Two years old (sic) issue about maven. Thanks to @twinforces, @lennartkoopmann and @gilesw. Closes Issues #51 and #57.

Release 1.0.2
-------------

2013-04-25

   ENH: (@nirvdrum) Added this change log

   ENH: (@radimk) Issue #59: Allow null short messages but do not allow both.

   ENH: (@radimk) Issue #58: Common logging pattern log.warn(null, ex) doesn't work.

   DEF: (@siaynoq) Issue #54: Unit test fail randomly

