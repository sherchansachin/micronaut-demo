package com.example.endPoints;

import com.example.DemoReply;
import com.example.DemoRequest;
import com.example.DemoServiceGrpc;
import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;

@Singleton
public class DemoEndpoints extends DemoServiceGrpc.DemoServiceImplBase {

    @Override
    public void send(DemoRequest request, StreamObserver<DemoReply> responseObserver) {
//        catch the request from client

        var req = request.getName();

        var rep = "Hello! from server " + req;

        DemoReply reply = DemoReply.newBuilder().setMessage(rep).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();


    }
}
