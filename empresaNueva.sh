#! /bin/bash

HOST='files141.hostinger.com'  
USER='u856265677'  
PASS='H00W6odR'  

echo "IdEmpresa" $1
cd /kaltia/empresa/
mkdir $1
cd $1 
mkdir images
cd images
pwd

ftp -n $HOST <<END_SCRIPT
quote USER $USER
quote PASS $PASS
cd kaltia/empresa
mkdir $1
cd $1
mkdir images
cd images
quit
END_SCRIPT
exit 0
