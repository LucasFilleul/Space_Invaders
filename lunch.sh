rm bin/*.class
cd src/
javac *.java
mv *.class ../bin/
cd ../bin/
java LancerApplication
