import * as React from 'react';
import { Formik, Field, Form, FormikHelpers, FormikProps } from 'formik';
import { Button, FormLayout, TextArea, TextField } from 'react-vaadin-components';
import Product from 'Frontend/generated/com/example/application/data/entity/Product';
import { ProductEndpoint } from 'Frontend/generated/endpoints';
import { FormikTextArea } from 'Frontend/components/FormikFields';

const initialProduct: Product = {
  name: '',
  description: '',
};

export function Pricing(): React.ReactElement {
  return (
    <>
      <h2>New Product</h2>
      <Formik
        initialValues={initialProduct}
        onSubmit={async (values: Product, { setSubmitting }: FormikHelpers<Product>) => {
          await ProductEndpoint.saveProduct(values);
          setSubmitting(false);
        }}
      >
        {(formikProps: FormikProps<Product>) => (
          <Form>
            <FormLayout responsiveSteps={[{ columns: 1 }]}>
              <FormikTextArea
                name="description"
                label="Description"
                placeholder="Enter description"
                required
              ></FormikTextArea>

              <Button disabled={formikProps.isSubmitting} onClick={formikProps.submitForm}>
                Submit
              </Button>
            </FormLayout>
          </Form>
    )}
      </Formik>
    </>
  );
}
