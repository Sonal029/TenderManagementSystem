package Tender.DAO;

import java.util.Scanner;

import Tender.DTO.vendor;
import Tender.DTO.vendorImpl;

public interface VendorDAO 
{
   public void vendorRegistration(vendor v); 
   
   public boolean vendorAuthentication(String user , String pass);
}
