package com.example.Seminar5homework.FactoryMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;



public class ExampleFabricMethod {

    public ExampleFabricMethod(){
        new FabricServiceFactory();
    }

    public interface IFabric {
        public IFabric doSome();
    }
    @Service("Type1")
    public class RealizationType1 implements IFabric{
        private Logger logger = Logger.getLogger(ExampleFabricMethod.class.getName());

        @Override
        public IFabric doSome() {
            logger.info("====Realization type 1 fabric method====");
            return null;
        }
    }
    @Service("Type2")
    public class RealizationType2 implements IFabric{
        private Logger logger = Logger.getLogger(ExampleFabricMethod.class.getName());

        @Override
        public IFabric doSome() {
            logger.info("====Realization type 2 fabric method====");
            return null;
        }
    }
    @Component
    public class FabricServiceFactory{

        private Map<String, IFabric> service;

        public FabricServiceFactory(){
            fabricMethod("Type1");
        }

        public IFabric fabricMethod(String method){
            return service.get(method).doSome();
        }

    }





}
