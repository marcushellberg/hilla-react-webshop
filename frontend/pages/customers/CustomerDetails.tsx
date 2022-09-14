import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { CustomersEndpoint } from 'Frontend/generated/endpoints';
import CustomerDTO from "Frontend/generated/com/example/application/data/dto/CustomerDTO";

export function CustomerDetails() {
  let { id } = useParams<'id'>();
  const [customer, setCustomer] = useState<CustomerDTO>();

  async function fetchCustomer() {
    if (id) {
      setCustomer(await CustomersEndpoint.findCustomerById(id));
    }
  }

  useEffect(() => {
    fetchCustomer();
  }, [id]);

  return (
    <>
      {!customer && <h2>Please select a customer</h2>}
      {customer && (
        <div className="m-xl">
          <h2>{customer.name}</h2>
        </div>
      )}
    </>
  );
}
