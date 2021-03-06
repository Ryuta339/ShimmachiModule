JAVAC	= javac
JAVA	= java
JAVADOC	= javadoc
FLAGS	= -deprecation -Xlint:none
BIN		= bin
SRC		= src
PACKPATH= titrail/mokei/shimmachi
PACKAGE	= titrail.mokei.shimmachi
DOC		= doc
CLPATH	= $(BIN):$(CLASSPATH)
EP		= $(PACKAGE).main.Main
LIBRARY = lib/jSerialComm-2.6.0.jar



exec: 
	$(JAVA) -cp $(BIN) $(EP)


all:
	$(JAVAC) $(FLAGS) -d $(BIN) $^


%.pack:	$(SRC)/$(PACKPATH)/%/*.java $(SRC)/$(PACKPATH)/%/*/*.java
	$(JAVAC) -cp $(CLPATH):$(LIBRARY) $(FLAGS) -d $(BIN) $^


cline:
	$(JAVA) -cp $(BIN) $(CLINE)


doc:	$(SRC)/$(PACKPATH)/*/*.java $(SRC)/$(PACKPATH)/*/*/*.java
	$(JAVADOC) -d $(DOC) $^

.PHONY: clean
clean:
	rm -rf $(BIN)/$(PACKPATH)/*/*.class $(BIN)/$(PACKPATH)/*/*/*.class
