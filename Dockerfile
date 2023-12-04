FROM microsoft/mssql-server-linux
ENV MSSQL_SA_PASSWORD=dockerStrongPwd123
ENV ACCEPT_EULA=Y

COPY ./MASTER_DB_BACKUP1203.bak /var/opt/mssql/backup/MASTER_DB_BACKUP1203.bak
COPY restore_db.sql restore_db.sql
RUN (/opt/mssql/bin/sqlservr --accept-eula & ) | grep -q "Starting database restore" && /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'dockerStrongPwd123' -d master -i restore_db.sql