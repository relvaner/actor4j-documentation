/*
 * Copyright (c) 2015, David A. Bauer
 */
package actor4j.core;

import java.util.List;
import java.util.UUID;

import actor4j.core.actors.Actor;
import actor4j.core.messages.ActorMessage;
import actor4j.core.mono.MonoActorSystemImpl;
import actor4j.core.utils.ActorFactory;
import actor4j.core.utils.ActorGroup;

public class ActorSystem {
	protected ActorSystemImpl system;
	
	public final UUID USER_ID;
	public final UUID SYSTEM_ID;
	
	public ActorSystem() {
		this(null);
	}
	
	public ActorSystem(String name) {
		super();
		
		system = new MonoActorSystemImpl(name, this);
		
		USER_ID    = system.USER_ID;
		SYSTEM_ID  = system.SYSTEM_ID;
	}
	
	public String getName() {
		return system.getName();
	}
	
	public ActorSystem setClientRunnable(ActorClientRunnable clientRunnable) {
		system.setClientRunnable(clientRunnable);
		
		return this;
	}
	
	public ActorSystem analyze(ActorAnalyzerThread analyzerThread) {
		system.analyze(analyzerThread);
		
		return this;
	}
	
	public int getParallelismMin() {
		return system.getParallelismMin();
	}
	
	public ActorSystem setParallelismMin(int parallelismMin) {
		system.setParallelismMin(parallelismMin);
		
		return this;
	}

	public int getParallelismFactor() {
		return system.getParallelismFactor();
	}
	
	public ActorSystem setParallelismFactor(int parallelismFactor) {
		system.setParallelismFactor(parallelismFactor);
		
		return this;
	}

	public void setSoftMode(boolean softMode, long softSleep) {
		system.setSoftMode(softMode, softSleep);
	}

	public ActorSystem softMode() {
		system.softMode();
		
		return this;
	}
	
	public ActorSystem hardMode() {
		system.hardMode();
		
		return this;
	}
	
	public ActorSystem setDebugUnhandled(boolean debugUnhandled) {
		system.setDebugUnhandled(debugUnhandled);
		
		return this;
	}
		
	public ActorSystem addURI(String uri) {
		system.addURI(uri);
		
		return this;
	}
	
	public UUID addActor(Class<? extends Actor> clazz, Object... args) {
		return system.addActor(clazz, args);
	}
	
	public UUID addActor(ActorFactory factory) {
		return system.addActor(factory);
	}
	
	public ActorSystem setAlias(UUID id, String alias) {
		system.setAlias(id, alias);
		
		return this;
	}
		
	public ActorSystem send(ActorMessage<?> message) {
		system.send(message);
		
		return this;
	}
	
	public ActorSystem broadcast(ActorMessage<?> message, ActorGroup group) {
		system.broadcast(message, group);
		
		return this;
	}
	
	public ActorTimer timer() {
		return system.timer();
	}
	
	public void start() {
		system.start();
	}
	
	public void start(Runnable onTermination) {
		system.start(onTermination);
	}
	
	public void shutdownWithActors() {
		system.shutdownWithActors();
	}
	
	public void shutdownWithActors(final boolean await) {
		system.shutdownWithActors(await);
	}
	
	public void shutdown() {
		system.shutdown();
	}
	
	public void shutdown(boolean await) {
		system.shutdown(await);
	}
	
	public List<String> getServerURIs() {
		return system.getServerURIs();
	}
	
	public ActorSystemImpl underlyingImpl() {
		return system;
	}
}
