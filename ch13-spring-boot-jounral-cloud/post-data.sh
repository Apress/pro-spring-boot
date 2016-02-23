#!/bin/bash
me=`basename "$0"`

if [ -z "$1" ]
then
    echo "You must provide a URL."
    echo "Usage: $me journal.pivotal.io" 
    exit 0
fi

curl -i -X POST -H "Content-Type:application/json" -d '{ "title":"Cloud Foundry","summary":"Learn about Cloud Foundry and push a Spring Boot Application","created":"2016-04-05"}' $1/rest/journal
curl -i -X POST -H "Content-Type:application/json" -d '{ "title":"Cloud Foundry Summit","summary":"Attend to the Summit in Santa Clara","created":"2016-05-05"}' $1/rest/journal
curl -i -X POST -H "Content-Type:application/json" -d '{ "title":"Spring Platform","summary":"Attend to the Spring Platform event","created":"2016-08-01"}' $1/rest/journal
curl -i -X POST -H "Content-Type:application/json" -d '{ "title":"Spring Boot","summary":"Learn more about Spring Boot","created":"2016-09-18"}' $1/rest/journal
curl -i -X POST -H "Content-Type:application/json" -d '{ "title":"Books","summary":"Buy some Spring Boot books","created":"2016-10-03"}' $1/rest/journal
