/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceaot.ejb;

import com.ceaot.entity.Collector;
import com.ceaot.entity.Item;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author stephankranenfeld
 */
@Stateless
@LocalBean
public class ItemEJB {
    //persistent unit setup
    @PersistenceContext(unitName = "ceaotPU")
    private EntityManager em;
    @Resource
    SessionContext ctx;
    
    //creates the item
    public Item createCollector(Item itm){
        em.persist(itm);
        return itm;
    }
    
    //updates the item
    public void updateCollector(Item itm){
        em.merge(itm);
    }
    
    //returns the list of topic groups
    public List<Item> getTopics(int groupId){
        
        //grabs the complete list of topic groups
        Query query = em.createNamedQuery("getAllItems");
        List<Item> itemList = query.getResultList();
        return itemList;
    }
    
}