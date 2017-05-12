#!/usr/bin/env bash

ACCT=$1
USER=$2
PASS=$3

sbt "runMain com.ofx.example.Driver $1 $2 $3"
