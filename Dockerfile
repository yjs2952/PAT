FROM ubuntu:18.04

RUN apt update \
	&& apt install -y --no-install-recommends oracle-java8-installer oracle-java8-set-default \

EXPOSE 80
