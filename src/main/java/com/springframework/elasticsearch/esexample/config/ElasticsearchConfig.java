package com.springframework.elasticsearch.esexample.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;


@Configuration
@EnableElasticsearchRepositories(basePackages="com.springframework.elasticsearch.esexample.repositories")
public class ElasticsearchConfig {

    @Value("${spring.elasticsearch.jest.proxy.host}")
    private String elasticsearchHost;
    @Value("${spring.elasticsearch.jest.proxy.port}")
    private int elasticsearchPort;
    @Value("${spring.data.elasticsearch.cluster-name}")
    private String elasticsearchClusterName;

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception{
        return new ElasticsearchTemplate(client());
    }
    @Bean
    public Client client() throws Exception{
        Settings elasticsearchSetting = Settings.settingsBuilder()
                .put("cluster.name",elasticsearchClusterName).build();
        return TransportClient.builder()
                .settings(elasticsearchSetting)
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName(elasticsearchHost), elasticsearchPort));

    }

}
