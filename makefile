PACKAGE = fr.kanassoulier.literomantik
SOURCEDIR = ./src/fr/kanassoulier/literomantik
BUILDDIR = ./build
DOCDIR = ./doc/
JARNAME = literomantik.jar
CLASSP = libs/mariadb-client.jar
MANIFESTPATH = Manifest.txt
VPATH = $(SOURCEDIR) $(SOURCEDIR)/enums $(SOURCEDIR)/utils $(SOURCEDIR)/landing $(SOURCEDIR)/end $(SOURCEDIR)/gui $(SOURCEDIR)/components $(SOURCEDIR)/game

BUILD = build/fr/kanassoulier/literomantik

all:
	@make build
	@make jar
	@make run

build:
	@echo "Building..."
	@make compile
	@echo "Done."

run: $(JARNAME)
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

jar: compile
	@echo "Creating jar..."
	@jar cfm $(JARNAME) $(MANIFESTPATH) -C $(BUILDDIR) fr/kanassoulier/literomantik resources .env
	@echo "Done."

compile : $(BUILD)/Main.class

$(JARNAME): 
	@make jar



$(BUILD)/Main.class : Main.java $(BUILD)/utils/SoundPlayer.class $(BUILD)/utils/Environment.class $(BUILD)/landing/LandingMenu.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/Options.class : Options.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 


$(BUILD)/enums/Biome.class : Biome.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 


$(BUILD)/KButtonType.class : KButtonType.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/enums/KeyboardKey.class : enums/KeyboardKey.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/enums/SoundChannel.class : enums/SoundChannel.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/enums/TileSide.class : enums/TileSide.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/enums/KCheckBox.class : utils/KCheckBox.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 


$(BUILD)/utils/Database.class : Database.java $(BUILD)/end/EndGameInfos.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/utils/Environment.class : Environment.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/utils/FontLoader.class : FontLoader.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/utils/Hexagon.class : Hexagon.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/utils/ImageLoader.class : ImageLoader.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/utils/ScoreLogic.class : ScoreLogic.java $(BUILD)/enums/TileSide.class $(BUILD)/enums/Biome.class $(BUILD)/game/Board.class $(BUILD)/game/PlaceableTile.class $(BUILD)/game/Cell.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/utils/SoundPlayer.class : SoundPlayer.java $(BUILD)/enums/SoundChannel.class $(BUILD)/Options.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/utils/Seed.class : Seed.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 


$(BUILD)/components/KButton.class : KButton.java $(BUILD)/enums/KButtonType.class $(BUILD)/components/KButtonListener.class $(BUILD)/utils/FontLoader.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/components/KButtonListener.class : KButtonListener.java $(BUILD)/components/KButton.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/components/KTextField.class : KTextField.java $(BUILD)/utils/FontLoader.class $(BUILD)/components/KTextFieldInput.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/components/KTextFieldInput.class : KTextFieldInput.java $(BUILD)/utils/FontLoader.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/components/KTextFieldSubmit.class : KTextFieldSubmit.java $(BUILD)/components/KTextFieldSubmitListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/components/KTextFieldSubmitListener.class : KTextFieldSubmitListener.java $(BUILD)/components/KTextFieldSubmit.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/components/KCheckBox.class : KCheckBox.java $(BUILD)/components/KCheckBoxContent.class $(BUILD)/components/KCheckBoxContentListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/components/KCheckBoxContent.class : KCheckBoxContent.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/components/KCheckBoxContentListener.class : KCheckBoxContentListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 



$(BUILD)/end/EndGameInfos.class : EndGameInfos.java $(BUILD)/utils/Database.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/end/EndGameTextFieldListener.class : EndGameTextFieldListener.java $(BUILD)/game/Game.class $(BUILD)/utils/Database.class $(BUILD)/end/EndGameInfos.class $(BUILD)/components/KTextFieldInput.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/end/EndMenu.class : EndMenu.java $(BUILD)/end/EndGameTextFieldListener.class $(BUILD)/end/EndMenuButtonsRow.class $(BUILD)/components/KTextFieldInput.class $(BUILD)/utils/ScoreLogic.class $(BUILD)/end/EndMenuListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/end/EndMenuButtonListener.class : EndMenuButtonListener.java $(BUILD)/components/KButton.class $(BUILD)/game/Game.Class $(BUILD)/landing/LandingMenu.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/end/EndMenuButtonsRow.class : EndMenuButtonsRow.java $(BUILD)/components/KButton.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/end/EndMenuListener.class : EndMenuListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 


$(BUILD)/game/Board.class : Board.java $(BUILD)/game/Cell.class $(BUILD)/game/AbstractBoard.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/Cell.class : Cell.java $(BUILD)/utils/Hexagon.class $(BUILD)/enums/TileSide.class $(BUILD)/game/AbstractBoard.class $(BUILD)/game/AbstractCell.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/EmptyCell.class : EmptyCell.java $(BUILD)/game/Cell.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/Game.class : Game.java $(BUILD)/game/Board.class $(BUILD)/game/GameInteractionHandler.class $(BUILD)/gui/GameKeyListener.class $(BUILD)/gui/CloseGameDialogListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $^ 

$(BUILD)/game/GameInteractionHandler.class : game/GameInteractionHandler.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/GameKeyListener.class : game/GameKeyListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/PlaceableArea.class : game/PlaceableArea.java $(BUILD)/game/PlaceableAreaListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/PlaceableAreaListener.class : PlaceableAreaListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/PlaceableTile.class : PlaceableTile.java $(BUILD)/game/Cell.class $(BUILD)/game/EmptyCell.class $(BUILD)/game/Tile.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/Tile.class : Tile.java $(BUILD)/game/Cell.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/game/Board.class : Board.java temp
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $<

temp : $(BUILD)/utils/Hexagon.class $(BUILD)/enums/TileSide.class  $(BUILD)/enums/Biome.class $(BUILD)/gui/AbstractGui.class

$(BUILD)/gui/CloseGameDialog.class : CloseGameDialog.java $(BUILD)/game/Game.class $(BUILD)/gui/CloseGameDialogListener.class $(BUILD)/components/KButton.class $(BUILD)/enums/KButtonType.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/CloseGameDialogButtonListener.class  : CloseGameDialogButtonListener.java $(BUILD)/game/Game.class $(BUILD)/components/KButton.class $(BUILD)/enums/KButtonType.class $(BUILD)/utils/SoundPlayer.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/CloseGameDialogListener.class : CloseGameDialogListener.java $(BUILD)/game/Game.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/AbstractGui.class : AbstractGui.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/Gui.class : Gui.java $(BUILD)/gui/ScoreUpdate.class $(BUILD)/gui/KeyInfo.class $(BUILD)/gui/TileStack.class $(BUILD)/gui/Scoreboard.class $(BUILD)/gui/PreviewTile.class $(BUILD)/gui/AbstractGui.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/KeyInfo.class : KeyInfo.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/PauseWindow.class : PauseWindow.java $(BUILD)/gui/PauseWindowButton.class $(BUILD)/game/Game.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/PauseWindowButton.class : PauseWindowButton.java $(BUILD)/components/KButton.class $(BUILD)/enums/KButtonType.class $(BUILD)/gui/PauseWindowKeyListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/PauseWindowButtonsListener.class : PauseWindowButtonsListener.java $(BUILD)/gui/PauseWindow.class $(BUILD)/components/KButton.class $(BUILD)/game/Game.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/PauseWindowKeyListener.class : PauseWindowKeyListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

# $(BUILD)/gui/AbstractPreviewTile.class : AbstractPreviewTile.java $(BUILD)/game/Tile.class $(BUILD)/Options.class
# 	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/PreviewTile.class : PreviewTile.java Tile.class $(BUILD)/Options.class $(BUILD)/gui/PreviewTileTimerListener.class $(BUILD)/enums/Biome.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/PreviewTileTimerListener.class : PreviewTileTimerListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/Scoreboard.class : Scoreboard.java ScoreLogic.class $(BUILD)/gui/Gui.class $(BUILD)/utils/FontLoader.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/ScoreUpdate.class : ScoreUpdate.java $(BUILD)/game/Game.class $(BUILD)/utils/FontLoader.class $(BUILD)/gui/Gui.Class $(BUILD)/gui/ScoreUpdateTimerListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/ScoreUpdateTimerListener.class : ScoreUpdateTimerListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/gui/TileStack.class : TileStack.java $(BUILD)/game/Game.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 


$(BUILD)/landing/LandingMenu.class : LandingMenu.java $(BUILD)/utils/ImageLoader.class $(BUILD)/utils/FontLoader.class $(BUILD)/landing/LandingMenuSidebar.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/LandingMenuControlButton.class : LandingMenuControlButton.java $(BUILD)/enums/KButtonType.class $(BUILD)/landing/LandingMenuControlButtonListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/LandingMenuControlButtonContainer.class : LandingMenuControlButtonContainer.java $(BUILD)/landing/LandingMenuControlButton.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/LandingMenuControlButtonListener.class : LandingMenuControlButtonListener.java $(BUILD)/landing/SeedSelector.class $(BUILD)/gui/Settings.class $(BUILD)/landing/SeedSelectorButton.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/LandingMenuLeaderboard.class : LandingMenuLeaderboard.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/LandingMenuSidebar.class : LandingMenuSidebar.java $(BUILD)/game/Game.class $(BUILD)/landing/LandingMenuLeaderboard.class $(BUILD)/landing/LandingMenuControlButtonContainer.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/SeedSelector.class : SeedSelector.java $(BUILD)/landing/SeedSelectorSubmitListener.class $(BUILD)/components/KTextField.class $(BUILD)/landing/SeedSelectorButton.class $(BUILD)/landing/SeedSelectorButtonListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/SeedSelectorButton.class : SeedSelectorButton.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/SeedSelectorButtonListener.class : SeedSelectorButtonListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/SeedSelectorSubmitListener.class : SeedSelectorSubmitListener.java $(BUILD)/components/KTextField.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/Settings.class : Settings.java $(BUILD)/gui/SettingsButtonListener.class
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 

$(BUILD)/landing/SettingsButtonListener.class : SettingsButtonListener.java
	@javac -d $(BUILDDIR) -cp $(BUILDDIR) $< 