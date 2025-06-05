package com.github.api.hexagonal.architecture;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


@AnalyzeClasses(packages = "com.github.api.hexagonal")
public class NamingConventionTest {

    @ArchTest
    public static final ArchRule consumersShouldBeInConsumerPackage = classes()
            .that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapters.in.consumer")
            .as("Consumer classes reside inside package in adapters.in.consumer package");


    @ArchTest
    static final ArchRule controllersShouldBeInControllerPackage = classes()
            .that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAPackage("..adapters.in.controller")
            .as("Controller classes reside inside package in adapters.in.controller package");


    @ArchTest
    static final ArchRule mappersShouldBeMapperPackage = classes()
            .that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage("..adapters.in.consumer.mapper",
                    "..adapters.in.controller.mapper", "..adapters.out.client.mapper",
                    "..adapters.out.repository.mapper")
            .as("Mapper classes should reside inside mapper package in controller, consumer, client, repository");


    @ArchTest
    static final ArchRule messageShouldBeMessagePackage = classes()
            .that()
            .haveNameMatching(".*Message")
            .should()
            .resideInAnyPackage("..adapters.in.consumer.message")
            .as("Message classes should reside inside message package in consumer package");


    @ArchTest
    static final ArchRule requestShouldBeRequesrPackage = classes()
            .that()
            .haveNameMatching(".*Request")
            .should()
            .resideInAnyPackage("..adapters.in.controller.request")
            .as("Request classes should reside inside request package in controller package");


    @ArchTest
    static final ArchRule responseShouldBeResponsePackage = classes()
            .that()
            .haveNameMatching(".*Response")
            .should()
            .resideInAnyPackage("..adapters.in.controller.response",
                    "..adapters.out.client.response")
            .as("Response classes should reside inside response package in controller, client package");


    @ArchTest
    public static final ArchRule shouldBeSuffixedConsumer = classes()
            .that()
            .resideInAPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer");

    @ArchTest
    public static final ArchRule shouldBeSuffixedController = classes()
            .that()
            .resideInAPackage("..controller")
            .should()
            .haveSimpleNameEndingWith("Controller");


    @ArchTest
    public static final ArchRule shouldBeSuffixedMapper = classes()
            .that()
            .resideInAPackage("..mapper")
            .should()
            .haveSimpleNameEndingWith("Mapper")
            .orShould()
            .haveSimpleNameEndingWith("MapperImpl");
}
