#!/usr/bin/env bash
java -jar protoc-jar-3.6.0.jar -v3.6.0  --include_std_types -I. --java_shaded_out=../java messages.proto