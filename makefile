PACKAGE = fr.kanassoulier.dorfromantik
ENTRY = Main
SOURCEDIR = ./src/fr/kanassoulier/dorfromantik/
BUILDDIR = ./build/
DOCDIR = ./doc/
JARNAME = dorfromantik.jar
CLASSP = ./libs/mariadb-client.jar

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
	@java -cp $(CLASSP) -jar $(BUILDDIR)$(JARNAME)
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
	@jar cvfe $(BUILDDIR)$(JARNAME) $(PACKAGE).$(ENTRY) -C $(BUILDDIR) fr/kanassoulier/dorfromantik resources .env
	@echo "Done."