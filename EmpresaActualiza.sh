#! /bin/bash

HOST='files141.hostinger.com'  
USER='u856265677'  
PASS='H00W6odR'  

echo "IdEmpresa" $1
cd /kaltia/empresa/$1/images
pwd

ftp -n $HOST <<END_SCRIPT
quote USER $USER
quote PASS $PASS
quote pas
cd kaltia/empresa/$1/images
binary
put $2 $2
quit
END_SCRIPT
exit 0
