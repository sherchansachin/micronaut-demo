package com.example.server;


import com.example.endPoints.DemoEndpoints;
import io.grpc.BindableService;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.ServerTransportFilter;
import io.micronaut.grpc.server.GrpcServerBuilder;
import io.micronaut.grpc.server.GrpcServerConfiguration;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class DemoServer extends GrpcServerBuilder {

    @Inject
    DemoEndpoints demoEndpoints;

    @Override
    protected ServerBuilder<?> serverBuilder(GrpcServerConfiguration configuration, List<BindableService> serviceList, List<ServerInterceptor> interceptors, List<ServerTransportFilter> serverTransportFilters) {
        return ServerBuilder.forPort(50051).addService(demoEndpoints);
    }
}
