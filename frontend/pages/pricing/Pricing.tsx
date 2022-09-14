import * as React from 'react';
import { Formik, Field, Form, FormikHelpers, FormikProps } from 'formik';
import { Button, FormLayout, TextArea, TextField } from 'react-vaadin-components';
import { ProductEndpoint } from 'Frontend/generated/endpoints';
import { FormikTextArea } from 'Frontend/components/FormikFields';
import ProductDTO from "Frontend/generated/com/example/application/data/dto/ProductDTO";

const initialProduct: ProductDTO = {
  name: '',
  description: '',
};

export function Pricing(): React.ReactElement {
  return (
    <>
      <h2>New Product</h2>
      <Formik
        initialValues={initialProduct}
        onSubmit={async (values: ProductDTO, { setSubmitting }: FormikHelpers<ProductDTO>) => {
          await ProductEndpoint.saveProduct(values);
          setSubmitting(false);
        }}
      >
        {(formikProps: FormikProps<ProductDTO>) => (
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
