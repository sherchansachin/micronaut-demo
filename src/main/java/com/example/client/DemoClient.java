package com.example.client;

import com.example.DemoReply;
import com.example.DemoRequest;
import com.example.DemoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DemoClient {

    public static void main(String[] args) {
        DemoClient demoClient = new DemoClient();
        demoClient.run();
    }

    private void run() {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        unaryCall(channel);
    }

    private void unaryCall(ManagedChannel channel) {

        DemoServiceGrpc.DemoServiceBlockingStub client = DemoServiceGrpc.newBlockingStub(channel);


        DemoRequest request = DemoRequest.newBuilder()
                .setName("Sachin")
                .build();

        DemoReply response = client.send(request);
        System.out.println(response.getMessage());
    }
}
