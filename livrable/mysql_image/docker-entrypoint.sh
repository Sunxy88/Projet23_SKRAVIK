#!/bin/bash
mysql -uroot -p${MYSQL_ROOT_PASSWORD} << EOF
source ./init_table_data.sql
EOF