cd iTrust2/

PID=`/sbin/lsof -i -n -P | grep TCP | grep 7719 | tr -s " " "\n" | sed -n 2p`
echo $PID
kill $PID || true

mvn spring-boot:run -Dspring-boot.run.profiles=production &