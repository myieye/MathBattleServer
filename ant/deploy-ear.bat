echo Deploying ear...
call %JBOSS_HOME%/bin/jboss-cli.bat --connect --command="deploy --force ./mathbattle.server.ear"