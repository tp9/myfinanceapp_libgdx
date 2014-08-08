package com.myfinanceapp.game;

import com.badlogic.gdx.Game;

public class MyFinanceApp extends Game {
	
	@Override
	public void create() {
		this.setScreen(new LoginScreen(this));
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		
	}

}
