package com.objectfrontier.training.java.webservices.statements;

public interface PersonStatements {

    String CREATE_QUERY = new StringBuilder().append("INSERT INTO service_person_ccc (first_name, last_name, email, birth_date, created_date, address_id, password, is_admin) ")
                                             .append("VALUES (?, ?, ?, ?, ?, ?, ?, ? )                                                                                        ").toString();

    String READ_QUERY = new StringBuilder().append("SELECT first_name, last_name, email, address_id, birth_date, created_date, password, is_admin ")
                                           .append("FROM service_person_ccc                                                                       ")
                                           .append("WHERE id = ?                                                                                  ").toString();

    String READ_ALL_QUERY = new StringBuilder().append("SELECT id, first_name, last_name, email, address_id, birth_date, created_date, password, is_admin ")
                                               .append("FROM service_person_ccc                                                                           ").toString();

    String GET_ADDRESS_ID = new StringBuilder().append("SELECT address_id       ")
                                               .append("FROM service_person_ccc ")
                                               .append("WHERE id = ?            ").toString();

    String UPDATE_QUERY = new StringBuilder().append("UPDATE service_person_ccc ")
                                             .append("SET first_name = ?,       ")
                                             .append("last_name = ?,            ")
                                             .append("email = ?,                ")
                                             .append("address_id = ?,           ")
                                             .append("birth_date = ?,           ")
                                             .append("password = ?,             ")
                                             .append("is_admin = ?,             ")
                                             .append("WHERE id = ?              ").toString();

    String DELETE_QUERY = new StringBuilder().append("DELETE                  ")
                                             .append("FROM service_person_ccc ")
                                             .append("WHERE id = ?            ").toString();
}
