package practise;

public  class fourwheeler implements automobiles {

	@Override
	public float takeyoousomewher() {
		// TODO Auto-generated method stub
		float distance_today = 0;
		float consumption_today = 0;
		float mileage_t;
		mileage_t = distance_today/consumption_today;
		System.out.println("mileage"+mileage_t);
		return  mileage_t;
	}

	@Override
	public void usesomeenergy() {
		// TODO Auto-generated method stub
		
	}

	

	
	

}
