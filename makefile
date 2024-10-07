all:
	javac -d build ./src/fr/kanassoulier/dorfromantik/*.java ./src/fr/kanassoulier/dorfromantik/board/*.java ./src/fr/kanassoulier/dorfromantik/gui/*.java ./src/fr/kanassoulier/dorfromantik/enums/*.java ./src/fr/kanassoulier/dorfromantik/utils/*.java -Xlint:deprecation
	java -cp build fr.kanassoulier.dorfromantik.Main

clean:
	rm -rf build/*

javadoc:
	javadoc -d doc -sourcepath src -subpackages fr.kanassoulier.dorfromantik