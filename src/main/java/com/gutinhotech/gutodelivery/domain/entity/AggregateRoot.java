package com.gutinhotech.gutodelivery.domain.entity;

public class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id) {
        super(id);
    }

}
