This project contains modified libGDX graphics and animation demos 
adapted from http://bit.ly/2fl6yXi (part 1) and http://bit.ly/2fMTPQ9 (part 2).
Reading through these tutorials is `highly recommended`.

This project is intended to help you to learn the most efficient method
available in libgdx to work with sprite sheets, that is, the 
[TextureAtlas](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/TextureAtlas.html) class.
Using a TextureAtlas makes it easier to access and manage the frames of your game's
animated sprites.

You will also want to look at the following:

* [TextureAtlas](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/TextureAtlas.html) documentation
* [TexturePacker](https://github.com/libgdx/libgdx/wiki/Texture-packer) documentation
    * [...a GUI for TexturePacker is available (read the README in the zip file)](http://rockhopper.monmouth.edu/~jchung/download/texturepacker-gui.zip)
* [PirateSecret](https://cssegit.monmouth.edu/csse360-projects-fall2015/pirate-secret) Fall 2015 project (primary example)

To clone this git project in Android Studio, copy the HTTPS URL

    https://cssegit.monmouth.edu/jchung/libgdx-animation-fa18.git

and use it when starting a new git project in Android Studio.

Run the desktop project using gradlew as usual. In DesktopLauncher.java, change between the demos

* GraphicsDemo1a, 
* GraphicsDemo1b, 
* GraphicsDemo1c, 
* AnimationDemo, 
* DragonAnimationDemo1, (update sprite from a texture atlas) 
* DragonAnimationDemo2, (update sprite from a texture atlas with interaction)
* DragonAnimationDemo3, (use separate Sprite subclass)
* DragonAnimationDemo4, (core game mechanic demo)
 
by uncommenting the appropriate line in 
[DesktopLauncher.java](https://cssegit.monmouth.edu/jchung/libgdx-animation-fa18/-/blob/master/desktop/src/com/gamefromscratch/graphicsdemo/desktop/DesktopLauncher.java).