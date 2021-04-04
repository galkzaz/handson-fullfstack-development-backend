# DB
sudo -u postgres createuser -P cardb

username:cardb
pass:cardb

sudo -u postgres createdb -O cardb cardb
sudo -u postgres psql -d cardb -c 'GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO cardb;'
sudo -u postgres psql -d cardb -c 'GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO cardb;'

# Run
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64 && export DEBUG=true && ./mvnw spring-boot:run