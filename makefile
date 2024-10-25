PACKAGE = fr.kanassoulier.dorfromantik
ENTRY = Main
SOURCEDIR = ./src/fr/kanassoulier/dorfromantik/
BUILDDIR = ./build/
DOCDIR = ./doc/
JARNAME = dorfromantik.jar
CLASSP = .:/libs/mariadb-client.jar


SOURCES := $(foreach dir, $(wildcard $(SOURCEDIR)**/), $(dir)*.java)

all:
	@make compile
	@make run

compile:
	@echo "Compiling..."
	@javac -d $(BUILDDIR) $(SOURCEDIR)*.java $(SOURCES) -Xlint:unchecked -Xlint:deprecation
	@echo "Done."

run: jar
	@echo "Running..."
	@java -cp $(CLASSP) -jar $(JARNAME)
	@echo "Done."

clean:
	@echo "Cleaning up..."
	@rm -rf $(BUILDDIR)* $(DOCDIR)*
	@echo "Done."

javadoc:
	@echo "Generating javadoc..."
	@javadoc -d $(DOCDIR) -sourcepath src -subpackages $(PACKAGE)
	@echo "Done."

jar: compile
	@echo "Creating jar..."
	@jar cvfe $(JARNAME) $(PACKAGE).$(ENTRY) -C $(BUILDDIR) fr/kanassoulier/dorfromantik resources .env
	@echo "Done."