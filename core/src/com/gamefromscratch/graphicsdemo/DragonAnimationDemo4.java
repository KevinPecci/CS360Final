/**
 * This demo, based on DragonAnimationDemo3, uses DragonSprite (a Sprite subclass)
 * for the dragon sprite.
 * 
 * This would serve as a game core mechanic demo, if the game was a duck hunt type game
 * (https://en.wikipedia.org/wiki/Duck_Hunt), but with dragons instead of ducks.
 */

package com.gamefromscratch.graphicsdemo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class DragonAnimationDemo4 implements ApplicationListener {
    private SpriteBatch batch;
    private float elapsedTime;
    // Make a dragon sprite
    private DragonSprite dragonSprite;
    // Can't match mouse click position to dragon sprite rectangle without camera
	OrthographicCamera camera;
 	// Needed to unproject mouse click position in render
	Vector3 mousePosition;
	// Cursor change code per http://tiny.cc/a061tz 
	// (original: http://www.martinrohwedder.dk/2016/02/libgdx-tutorial-how-to-change-the-mouse-cursor-image/)
	Pixmap cursorPixmap;
	
	
    @Override
    public void create() {        
        batch = new SpriteBatch();
        // Construct dragon sprite
        dragonSprite = new DragonSprite();
        // Create the camera & mousePosition vector
     	camera = new OrthographicCamera();
     	camera.setToOrtho(false, 1000, 1000); // Same width & height in DesktopLauncher
     	mousePosition = new Vector3();
     	
     	// Start dragonSprite off screen
     	dragonSprite.setPosition(-100, 500);
     	
     	// alienXhairs.png, when loaded as a Pixmap, must have dimensions that are a power of 2,
     	// e.g, 32, 64, 128 ...
     	cursorPixmap = new Pixmap( Gdx.files.internal("cursor/alienXhairs.png") );
     	Gdx.graphics.setCursor( Gdx.graphics.newCursor(cursorPixmap, cursorPixmap.getWidth() / 2, 
     			cursorPixmap.getHeight() / 2) );
    }

    @Override
    public void dispose() {
        batch.dispose();
        cursorPixmap.dispose();
    }

    @Override
    public void render() {        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
     	// Tell the camera to update its matrices.
     	camera.update();
     	// Tell the SpriteBatch to render in the
     	// coordinate system specified by the camera.
     	batch.setProjectionMatrix(camera.combined);
     	
        batch.begin();
        dragonSprite.draw(batch);
        batch.end();

    	elapsedTime += Gdx.graphics.getDeltaTime();

    	// Move dragonSprite across screen horizontally, or vertically...
    	if (dragonSprite.isAlive()) {
    		dragonSprite.setX(dragonSprite.getX() + 5);
    		// If dragonSprite leaves screen horizontally, it will come around again
    		if (dragonSprite.getX() > 1100) {
    			dragonSprite.setPosition(-100, 500);
    		}
    	}
    	else {
    		dragonSprite.setY(dragonSprite.getY() - 10);
    	}
    	
        // Set the next frame for the dragonSprite
        dragonSprite.update(elapsedTime);
        
        // If mouse click on dragon, kill dragon
        if (Gdx.input.isTouched()) {
        	// Camera unprojection of mouse click position explained at
        	// https://cssegit.monmouth.edu/jchung/libgdx.wiki/wikis/a-simple-game
			mousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(mousePosition);
			
        	if (dragonSprite.getBoundingRectangle().contains(mousePosition.x, mousePosition.y)
        			&& dragonSprite.isAlive()) {
        		dragonSprite.kill();
        	}
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
