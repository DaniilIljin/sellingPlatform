import React from 'react'

const Router = () => {
    const router = createBrowserRouter([
      {
        path: "/",
        element: <RootLayout />,
        errorElement: <ErrorPage />,
        children: [
          { index: true, element: <Home products={productData.products} /> },
          {
            path: "/shop",
            element: <Shop products={productData.products} />,
          },
          ...productData.products.map((product) => ({
            path: `shop/product/${product.id}`,
            element: <ProductDetail product={product} />,
          })),
        ],
      },
    ]);
  
    return (
      <ShopProvider>
        <RouterProvider router={router} />
      </ShopProvider>
    );
  };

export default Router