PACKAGE = fr.kanassoulier.dorfromantik
ENTRY = Main
SOURCEDIR = ./src/fr/kanassoulier/dorfromantik/
BUILDDIR = ./build/
DOCDIR = ./doc/
JARNAME = dorfromantik.jar
CLASSP = libs/mariadb-client.jar
MANIFESTPATH = Manifest.txt

SOURCES := $(foreach dir, $(wildcard $(SOURCEDIR)**/), $(dir)*.java)

all:
	@make compile
	@make jar
	@make run

compile:
	@echo "Compiling..."
	@javac -cp $(CLASSP) -d $(BUILDDIR) $(SOURCEDIR)*.java $(SOURCES) -Xlint:unchecked -Xlint:deprecation
	@echo "Done."

run:
	@echo "Running..."
	@java -jar $(JARNAME)
	@echo "Done."

clean:
	@echo "Cleaning up..."
	@rm -rf $(BUILDDIR)* $(DOCDIR)*
	@echo "Done."

javadoc:
	@echo "Generating javadoc..."
	@javadoc -d $(DOCDIR) -sourcepath src -subpackages $(PACKAGE)
	@echo "Done."

jar:
	@echo "Creating jar..."
	@jar cfm $(JARNAME) $(MANIFESTPATH) -C $(BUILDDIR) fr/kanassoulier/dorfromantik resources .env
	@echo "Done."